package com.progracol.backend.apirest.models.juego.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.progracol.backend.apirest.models.juego.dto.BingoParamBoardDTO;
import com.progracol.backend.apirest.models.juego.dto.BingoParamBoardWinnersDTO;

public interface IBingoParamBoardService {

	/**
	 * Obtiene la lista de ganadores de bingo param board en una lista <br>
	 * 
	 * @author Jonathan Mosquera.</a></br>
	 * @return
	 */
	List<BingoParamBoardWinnersDTO> evaluateBallotsOnBingoParamBoard(@Valid String[] numbers);

	/**
	 * Obtiene todos los datos de bingo_param_board <br>
	 * 
	 * @author Jonathan Mosquera.</a></br>
	 * @param pageable
	 * @return
	 */
	Page<BingoParamBoardDTO> findAllBingoParamBoards(Pageable pageable);

}
