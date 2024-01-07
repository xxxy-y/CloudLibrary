package cn.edu.tyut.interceptor;

import cn.edu.tyut.POJO.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author 羊羊
 * @ClassName ResourcesInterceptor
 * @SubmitTime 周六
 * @DATE 2024/1/6
 * @Time 12:06
 * @Package_Name cn.edu.tyut.interceptor
 */
public class ResourcesInterceptor implements HandlerInterceptor {
    private final List<String> ignoreUrl;

    @Contract(pure = true)
    public ResourcesInterceptor(List<String> ignoreUrl) {
        this.ignoreUrl = ignoreUrl;
    }

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("USER_SESSION");
        String uri = request.getRequestURI();
        if (uri.contains("login")) {
            return true;
        }
        if (user != null) {
            if("ADMIN".equals(user.getRole())) {
                return true;
            } else {
                for(String url : ignoreUrl) {
                    if(uri.contains(url)) {
                        return true;
                    }
                }
            }
            return true;
        }
        request.setAttribute("msg", "您还没有登录，请先登录！");
        // 路径需要是/WEB-INF/admin/login.jsp的，而不能只有/admin/login.jsp，因为这是forward，forward是相对于当前应用程序的路径来进行转发的
        request.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
