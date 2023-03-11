package com.example.persistence.base.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class SecurityUtils {

	/**
	 * @return logged in user username
	 */
	public static String getLoggedInUserUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	/**
	 * @return logged in user role list
	 */
	public static Collection<? extends GrantedAuthority> getLoggedInUserRoleList() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getAuthorities();
	}
	public static List<String> getLoggedInUserSAccess() {
		return BeanUtil.getBean(SecurityUtilsService.class).getLoggedInUserSAccess();
	}

	public static List<String> getLoggedInUserItems() {
		return BeanUtil.getBean(SecurityUtilsService.class).getLoggedInUserItems();
	}
	/**
	 * @return logged in user id
	 */
	public static String getLoggedInUserId() {
		return BeanUtil.getBean(SecurityUtilsService.class).getLoggedInUserId();
	}

	/**
	 * @return logged in center id
	 */
	public static String getLoggedInUserCenterId() {
		return BeanUtil.getBean(SecurityUtilsService.class).getLoggedInUserCenterId();
	}
	/**
	 * @return get only token value
	 */
	public static String getOnlyToken() {
		return BeanUtil.getBean(SecurityUtilsService.class).getOnlyToken();
	}

	/**
	 * @return get "Authorization" + " " + token value
	 */
	public static String getAuthorizationToken() {
		return BeanUtil.getBean(SecurityUtilsService.class).getAuthorizationToken();
	}

	/**
	 * @return get "Bearer" + " " + token value
	 */
	public static String getBearerToken() {
		return BeanUtil.getBean(SecurityUtilsService.class).getBearerToken();
	}

	/**
	 * Check if a user is authenticated.
	 *
	 * @return true if the user is authenticated, false otherwise
	 */
	public static boolean isAuthenticated() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		return Optional.ofNullable(securityContext.getAuthentication())
				.map(authentication -> authentication.getAuthorities().stream().noneMatch(
						grantedAuthority -> grantedAuthority.getAuthority().equals("AuthoritiesConstants.ANONYMOUS")))
				.orElse(false);
	}

	/**
	 * If the current user has a specific authority (security role).
	 * <p>
	 * The name of this method comes from the isUserInRole() method in the Servlet
	 * API
	 *
	 * @param authority the authority to check
	 * @return true if the current user has the authority, false otherwise
	 */
	public static boolean isCurrentUserInRole(String authority) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		return Optional
				.ofNullable(securityContext.getAuthentication()).map(authentication -> authentication.getAuthorities()
						.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(authority)))
				.orElse(false);
	}

	/**
	 * @return logged in class institute id
	 */
	public static String getLoggedInUserClassInstituteId() {
		return BeanUtil.getBean(SecurityUtilsService.class).getLoggedInClassInstituteId();
	}

	/**
	 * @return logged in setad id
	 */
	public static String getLoggedInUserSetadId() {
		return BeanUtil.getBean(SecurityUtilsService.class).getLoggedInUserSetadId();
	}

}