package com.progracol.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progracol.backend.apirest.models.juego.dto.BingoParamBoardDTO;
import com.progracol.backend.apirest.models.juego.dto.BingoParamBoardWinnersDTO;
import com.progracol.backend.apirest.models.juego.services.IBingoParamBoardService;
import com.progracol.backend.apirest.util.Constants;

import io.swagger.annotations.ApiOperation;

/**
 * Clase que expone los servicios GET, POST para el manejo de la clase bingo param boards <br>
 * 
 * @author Jonathan Mosquera.</a></br>
 */
@RestController
@RequestMapping("/api")
public class BingoParamBoardController {

	@Autowired
	private IBingoParamBoardService bingoParamBoardService;

	@ApiOperation(value = "Returns bingo_param_board details", notes = "Returns a List of bingo_param_board details.", response = BingoParamBoardDTO.class)
	@GetMapping("/bingo-param-board")
	public Page<BingoParamBoardDTO> getAllBingoParamBoardsPageable(@RequestParam(name = "page") Integer page,
			@RequestParam(name = "size") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return bingoParamBoardService.findAllBingoParamBoards(pageable);
	}

	@ApiOperation(value = "Returns winners bingo_param_board details", notes = "Returns a List of bingo_param_board details winners.", response = BingoParamBoardWinnersDTO.class)
	@PostMapping("/bingo-param-board/winners")
	public ResponseEntity<?> evaluateBallotsOnBingoParamBoard(@Valid @RequestBody String[] numbers) {

		Map<String, Object> response = new HashMap<>();

		if (numbers.length < 1) {
			response.put("mensaje", Constants.ERROR_SIZE_ARRAY_404);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		List<BingoParamBoardWinnersDTO> result = bingoParamBoardService.evaluateBallotsOnBingoParamBoard(numbers);
		return new ResponseEntity<List<BingoParamBoardWinnersDTO>>(result, HttpStatus.OK);
	}

}
