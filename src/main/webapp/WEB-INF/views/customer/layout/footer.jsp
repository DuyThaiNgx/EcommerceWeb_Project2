
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
<footer>
	<div class="container footer-container">
		<div class="footer-desc">
			<div class="footer-item">
				<h3>Giới thiệu</h3>
				<p>Trang mua sắm trực tuyến các sản phẩm chăm sóc da uy tín</p>
				<img src="${base}/img/bottom.png" alt="">
				<div class="icon-bottom">
					<a href=""><i class="fa-brands fa-facebook"></i></a> <a href=""><i
						class="fa-brands fa-youtube"></i></a> <a href=""><i
						class="fa-brands fa-twitter"></i></a> <a href=""><i
						class="fa-brands fa-instagram"></i></a>
				</div>
			</div>
			<div class="footer-item">
				<h3>Liên kết</h3>
				<ul class="menu-link">
					<li><a href="/product">Sản phẩm</a></li>
<%--					<li><a href="/admin/bill/search">Tìm kiếm</a></li>--%>
					<li><a href="#" id="scrollToTop">Tìm kiếm</a></li>
					<li><a href="/home">Giới thiệu</a></li>
					<li><a href="https://www.facebook.com/dthai.nevershuy/">Liên hệ</a></li>
					<li><a href="/login">Đăng nhập</a></li>
				</ul>
			</div>
			<div class="footer-item">
				<div class="contact">
					<h3>Thông tin liên hệ</h3>
					<p>
						<i class="fa-solid fa-location-dot"></i> Hà Đông, Hà Nội
					</p>
					<p>
						<i class="fa-solid fa-phone"></i> 0988423902
					</p>
					<p>
						<i class="fa-solid fa-fax"></i> 0988423902
					</p>
				</div>
			</div>
		</div>
	</div>
	<script>
		document.getElementById('scrollToTop').addEventListener('click', function(event) {
			// Ngăn chặn hành động mặc định của thẻ a
			event.preventDefault();
			// Cuộn lên đầu trang
			window.scrollTo({ top: 0, behavior: 'smooth' });
		});
	</script>
</footer>