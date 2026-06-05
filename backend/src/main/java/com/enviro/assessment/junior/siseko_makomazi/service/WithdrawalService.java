package com.enviro.assessment.junior.siseko_makomazi.service;

import com.enviro.assessment.junior.siseko_makomazi.dto.WithdrawalRequestDTO;
import com.enviro.assessment.junior.siseko_makomazi.dto.WithdrawalResponseDTO;
import com.enviro.assessment.junior.siseko_makomazi.model.Withdrawal;
import com.enviro.assessment.junior.siseko_makomazi.repository.WithdrawalRepository;
import com.enviro.assessment.junior.siseko_makomazi.validation.WithdrawalValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WithdrawalService {

    private final WithdrawalRepository withdrawalRepository;
    private final WithdrawalValidator withdrawalValidator;

    public WithdrawalService(WithdrawalRepository withdrawalRepository, WithdrawalValidator withdrawalValidator) {
        this.withdrawalRepository = withdrawalRepository;
        this.withdrawalValidator = withdrawalValidator;
    }

    public List<WithdrawalResponseDTO> getAllWithdrawals() {
        return withdrawalRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public WithdrawalResponseDTO processWithdrawal(WithdrawalRequestDTO request) {
        withdrawalValidator.validate(request);
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setAmount(request.getAmount());
        withdrawal.setReason(request.getReason());
        withdrawal.setStatus("Pending");
        withdrawal.setRequestedAt(LocalDateTime.now());
        Withdrawal saved = withdrawalRepository.save(withdrawal);
        return mapToDto(saved);
    }

    private WithdrawalResponseDTO mapToDto(Withdrawal withdrawal) {
        return new WithdrawalResponseDTO(
                withdrawal.getId(),
                withdrawal.getAmount(),
                withdrawal.getStatus(),
                withdrawal.getRequestedAt().toString()
        );
    }
}

