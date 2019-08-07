package by.yurusova.entranceExam.services.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Custom AuthenticationSuccessHandler implementation,
 * that redirect users to different pages after login,
 * page depends on it role.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services.security
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest httpServletRequest,
                                        final HttpServletResponse httpServletResponse,
                                        final Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String contextPath = httpServletRequest.getContextPath();
        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect(contextPath + "/admin/adminPage");
        }
        if (roles.contains("ROLE_TEACHER")) {
            httpServletResponse.sendRedirect(contextPath + "/account/teacherPage");
        }
        if (roles.contains("ROLE_STUDENT")) {
            httpServletResponse.sendRedirect(contextPath + "/account/studentPage");
        }
    }
}
