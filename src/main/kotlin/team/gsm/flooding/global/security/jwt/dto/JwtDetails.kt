package team.gsm.flooding.global.security.jwt.dto

import java.time.LocalDateTime

data class JwtDetails(
	val token: String,
	val expiredAt: LocalDateTime,
)
