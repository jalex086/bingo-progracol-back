package com.progracol.backend.apirest.models.juego.services;

import com.progracol.backend.apirest.models.juego.dto.BingoParamFigureDTO;

public interface IBingoParamFigureService {

	/**
	 * Obtiene una figura <br>
	 * 
	 * @author Jonathan Mosquera.</a></br>
	 * @param figureName
	 * @return
	 */
	BingoParamFigureDTO findByFigureName(String figureName);

	/**
	 * Actualiza las boardParamFigures <br>
	 * 
	 * @author Jonathan Mosquera.</a></br>
	 * @param positionWinner
	 * @param figureName
	 * @return
	 */
	BingoParamFigureDTO save(Boolean[] positionWinner, String figureName);

}
