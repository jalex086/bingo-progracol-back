package com.progracol.backend.apirest.models.juego.services;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progracol.backend.apirest.models.juego.dao.IBingoParamFigureDao;
import com.progracol.backend.apirest.models.juego.dto.BingoParamFigureDTO;
import com.progracol.backend.apirest.models.juego.entity.BingoParamFigure;

@Service
public class BingoParamFigureServiceImpl implements IBingoParamFigureService {

	@Autowired
	private IBingoParamFigureDao bingoParamFigureDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progracol.backend.apirest.models.juego.services.IBingoParamFigureService#findByFigureName(java.lang.String)
	 */
	@Override
	public BingoParamFigureDTO findByFigureName(String figureName) {
		BingoParamFigure bingoParamFigure = bingoParamFigureDao.finByFigureName(figureName);
		return this.createObject(bingoParamFigure);
	}

	/**
	 * convierte el entity en un DTO para ser enviado al front <br>
	 * 
	 * @author Jonathan Mosquera.</a></br>
	 * @param bingoParamFigure
	 * @return
	 */
	private BingoParamFigureDTO createObject(BingoParamFigure bingoParamFigure) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(bingoParamFigure, BingoParamFigureDTO.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progracol.backend.apirest.models.juego.services.IBingoParamFigureService#save(java.lang.Boolean[], java.lang.String)
	 */
	@Override
	public BingoParamFigureDTO save(Boolean[] positionWinner, String figureName) {
		BingoParamFigure entity = bingoParamFigureDao.finByFigureName(figureName);
		entity.setFigureName(figureName);
		entity.setPositionWinner(positionWinner);
		entity.setLastUpdatedAt(new Date().toInstant());
		return this.createObject(bingoParamFigureDao.save(entity));
	}

}
