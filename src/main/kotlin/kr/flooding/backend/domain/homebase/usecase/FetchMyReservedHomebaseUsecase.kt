package kr.flooding.backend.domain.homebase.usecase

import kr.flooding.backend.domain.homebase.dto.response.FetchMyReservedHomebaseResponse
import kr.flooding.backend.domain.homebase.repository.HomebaseGroupRepository
import kr.flooding.backend.global.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
@Transactional
class FetchMyReservedHomebaseUsecase(
	private val homebaseGroupRepository: HomebaseGroupRepository,
	private val userUtil: UserUtil,
) {
	fun execute(): List<FetchMyReservedHomebaseResponse> =
		homebaseGroupRepository
			.findByProposerStudentAndAttendedAt(userUtil.getUser(), LocalDate.now())
			.map { FetchMyReservedHomebaseResponse.toDto(it, userUtil.getUser()) }
}
