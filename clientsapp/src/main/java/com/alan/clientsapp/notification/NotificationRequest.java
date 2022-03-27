package com.alan.clientsapp.notification;

public record NotificationRequest(Integer toCustomerId,
		String toCustomerName,
		String message) {}