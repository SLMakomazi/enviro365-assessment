package com.enviro.assessment.junior.siseko_makomazi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.enviro.assessment.junior.siseko_makomazi.dto.PortfolioDTO;
import com.enviro.assessment.junior.siseko_makomazi.model.Portfolio;
import com.enviro.assessment.junior.siseko_makomazi.repository.PortfolioRepository;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<PortfolioDTO> getAllPortfolios() {
        return portfolioRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public PortfolioDTO getPortfolioById(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow();
        return mapToDto(portfolio);
    }

    private PortfolioDTO mapToDto(Portfolio portfolio) {

        return new PortfolioDTO(
                portfolio.getId(),
                portfolio.getName(),
                portfolio.getTotalValue()
        );
    }
}