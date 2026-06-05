package com.enviro.assessment.junior.siseko_makomazi.service;

import com.enviro.assessment.junior.siseko_makomazi.dto.InvestorDTO;
import com.enviro.assessment.junior.siseko_makomazi.model.Investor;
import com.enviro.assessment.junior.siseko_makomazi.repository.InvestorRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestorService {

    private final InvestorRepository investorRepository;

    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public List<InvestorDTO> getAllInvestors() {
        return investorRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public InvestorDTO getInvestorById(Long id) {
        Investor investor = investorRepository.findById(id).orElseThrow();
        return mapToDto(investor);
    }

    private InvestorDTO mapToDto(Investor investor) {
        return new InvestorDTO(
                investor.getId(),
                investor.getName(),
                investor.getEmail(),
                investor.getAge(),
                investor.getBalance()
        );
    }
}

