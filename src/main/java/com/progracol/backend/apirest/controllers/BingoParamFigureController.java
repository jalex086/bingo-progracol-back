package com.progracol.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progracol.backend.apirest.models.juego.dto.BingoParamFigureDTO;
import com.progracol.backend.apirest.models.juego.services.IBingoParamFigureService;

import io.swagger.annotations.ApiOperation;

/**
 * Clase que expone los servicios GET, POST para el manejo de la clase bingo param figure <br>
 * 
 * @author Jonathan Mosquera.</a></br>
 */
@RestController
@RequestMapping("/api")
public class BingoParamFigureController {

	@Autowired
	private IBingoParamFigureService bingoParamFigureService;

	@ApiOperation(value = "Returns bingo_param_figure details", notes = "Returns a object of users details with a date of last modification.", response = BingoParamFigureDTO.class)
	@GetMapping("/bingo-param-figure")
	public BingoParamFigureDTO getBingoParamFigureByFigureName(@RequestParam(name = "figureName") String figureName) {
		return bingoParamFigureService.findByFigureName(figureName);
	}

	@ApiOperation(value = "Returns bingo_param_figure details", notes = "Returns a object of users details with a date of last modification.", response = BingoParamFigureDTO.class)
	@PutMapping("/bingo-param-figure")
	public BingoParamFigureDTO updateBingoParamFigureByFigureName(@RequestBody Boolean[] positionWinner,
			@RequestParam(name = "figureName") String figureName) {
		return bingoParamFigureService.save(positionWinner, figureName);
	}

}
