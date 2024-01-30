package com.selena.conf;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * kiểm tra Role của User Logined. Nếu guest thì về trang người dùng
 * ngược lại nếu là Admin thì vào trang Admin
 * @author dtngx
 *
 */
public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/**
	 * Lấy Role của user và trả về Url tương ứng
	 * @param authentication
	 * @return
	 */
	protected String determineTargetUrl(final Authentication authentication) {
		Map<String, String> roleTargetUrlMap = new HashMap<>();
		// Là admin thì trả về trang admin, là người dùng thì trả về home
		roleTargetUrlMap.put("ADMIN", "/admin/product/list");
		roleTargetUrlMap.put("GUEST", "/home");

		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			//Lấy tên của quyền.
			String authorityName = grantedAuthority.getAuthority();
			//Kiểm tra danh sách xem có tên quyền không
			if (roleTargetUrlMap.containsKey(authorityName)) {
				return roleTargetUrlMap.get(authorityName);
			}
		}
		// Nếu không tìm thấy URL mục tiêu nào cho quyền, ném một ngoại lệ IllegalStateException.
		throw new IllegalStateException();
	}
	// Xóa session sau khi hoàn thành quá trình xác thực
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		//Kiểm tra xem session có tồn tại không. Nếu không tồn tại (null), phương thức sẽ kết thúc mà không làm gì cả.
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
}
