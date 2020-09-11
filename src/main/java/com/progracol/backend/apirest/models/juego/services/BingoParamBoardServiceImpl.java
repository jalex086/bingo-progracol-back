package com.progracol.backend.apirest.models.juego.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Ordering;
import com.progracol.backend.apirest.models.juego.dao.IBingoParamBoardDao;
import com.progracol.backend.apirest.models.juego.dto.BingoParamBoardDTO;
import com.progracol.backend.apirest.models.juego.dto.BingoParamBoardWinnersDTO;
import com.progracol.backend.apirest.models.juego.entity.BingoParamBoard;
import com.progracol.backend.apirest.util.EntityConverter;

@Service
public class BingoParamBoardServiceImpl implements IBingoParamBoardService {

	@Autowired
	private IBingoParamBoardDao bingoParamBoardDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progracol.backend.apirest.models.services.IBingoParamBoardService#findAllBingoParamBoards(org.springframework.data.domain.Pageable)
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<BingoParamBoardDTO> findAllBingoParamBoards(Pageable pageable) {

		Page<BingoParamBoard> bingoParamBoards = bingoParamBoardDao.findAllBingoParamBoards(pageable);
		return EntityConverter.bingoParamBoardToDto(bingoParamBoards);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progracol.backend.apirest.models.juego.services.IBingoParamBoardService#evaluateBallotsOnBingoParamBoard(java.lang.String[])
	 */
	@Override
	@Transactional(readOnly = true)
	public List<BingoParamBoardWinnersDTO> evaluateBallotsOnBingoParamBoard(@Valid String[] numbers) {

		Integer[] arrayNumbers = EntityConverter.stringArrayToIntegerArray(numbers);

		List<BingoParamBoard> bingoParamBoards = bingoParamBoardDao.findAllBingoParamBoards();

		Integer[] arrayOrdenado = Arrays.copyOf(arrayNumbers, arrayNumbers.length);
		Arrays.sort(arrayOrdenado, Ordering.natural().nullsLast());

		return bingoParamBoards.parallelStream()
				.filter(b -> this.isEqualsArray(b.getBoardNumbers(), arrayOrdenado))
				.map(this::createObject)
				.collect(Collectors.toList());

	}

	/**
	 * convierte el entity en un DTO para ser enviado al front <br>
	 * 
	 * @author Jonathan Mosquera.</a></br>
	 * @param bingoParamBoard
	 * @return
	 */
	private BingoParamBoardWinnersDTO createObject(BingoParamBoard bingoParamBoard) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(bingoParamBoard, BingoParamBoardWinnersDTO.class);
	}

	/**
	 * ordena dos arrays de Integer y los compara <br>
	 * 
	 * @author Jonathan Msquera.</a></br>
	 * @param bingo
	 * @param array
	 * @return
	 */
	private boolean isEqualsArray(Integer[] bingo, Integer[] array) {
		Integer[] objeto1 = Arrays.copyOf(bingo, bingo.length);
		Arrays.sort(objeto1, Ordering.natural().nullsLast());
		return Arrays.equals(objeto1, array);
	}

}
