package kr.flooding.backend.domain.auth.dto.request

import jakarta.validation.constraints.NotNull

data class VerifyEmailRequest(
	@field:NotNull
	val email: String,
	@field:NotNull
	val code: String,
)
