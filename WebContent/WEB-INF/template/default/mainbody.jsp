<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


    <!-- search : where_togo_area_start  -->
	<tiles:insertAttribute name="search"/>
    <!-- search : where_togo_area_end  -->
    
    <!-- hotplace : popular_destination_area_start  -->
	<tiles:insertAttribute name="hotplace"/>
    <!-- hotplace : popular_destination_area_end  -->

    <!-- newsletter: newletter_area_start  -->
	<tiles:insertAttribute name="newsletter"/>
    <!-- newsletter : newletter_area_end  -->

	<!-- recommen -->
	<tiles:insertAttribute name="recommen"/>
	<!-- recommen -->

 	<!-- video -->
	<tiles:insertAttribute name="video"/>
	<!-- video -->

 	<!-- variation -->
	<tiles:insertAttribute name="variation"/>
	<!-- variation -->

    <!-- review : testimonial_area  -->
	<tiles:insertAttribute name="review"/>    
    <!-- review : testimonial_area  -->

    <!-- reviewDetail : recent_trip_area  -->
	<tiles:insertAttribute name="reviewDetail"/>    
    <!-- reviewDetail : recent_trip_area  -->