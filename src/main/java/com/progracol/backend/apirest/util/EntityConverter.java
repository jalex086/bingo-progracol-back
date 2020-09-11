package com.progracol.backend.apirest.util;

import java.util.Arrays;
import java.util.function.Function;

import org.springframework.data.domain.Page;

import com.progracol.backend.apirest.models.juego.dto.BingoParamBoardDTO;
import com.progracol.backend.apirest.models.juego.entity.BingoParamBoard;

public class EntityConverter {

	private EntityConverter() {

	}

	/**
	 * Se encarga de realizar el mapeo de la entidad al DTO <br>
	 * 
	 * @author Jonathan Mosquera.</a></br>
	 * @param bingoParamBoards
	 * @return
	 */
	public static Page<BingoParamBoardDTO> bingoParamBoardToDto(Page<BingoParamBoard> bingoParamBoards) {
		return bingoParamBoards.map(new Function<BingoParamBoard, BingoParamBoardDTO>() {

			@Override
			public BingoParamBoardDTO apply(BingoParamBoard t) {
				BingoParamBoardDTO dto = new BingoParamBoardDTO();
				dto.setId(t.getId());
				dto.setBoardNumbers(Arrays.toString(t.getBoardNumbers()));
				dto.setStatus(("A".equals(t.getStatus()) ? "Activo" : "Inactivo"));
				dto.setCreatedBy((t.getCreatedBy() == null) ? "" : t.getCreatedBy());
				dto.setLastUpdatedAt((t.getLastUpdatedAt() == null) ? "" : Constants.FORMATTER_GLOBAL_INSTANT.format(t.getLastUpdatedAt()));
				dto.setLastUpdatedBy((t.getLastUpdatedBy() == null) ? "" : t.getLastUpdatedBy());
				dto.setDeletedAt((t.getDeletedAt() == null) ? "" : Constants.FORMATTER_GLOBAL_INSTANT.format(t.getDeletedAt()));
				dto.setDeletedBy((t.getDeletedBy() == null) ? "" : t.getDeletedBy());
				dto.setCreatedAt((t.getCreatedAt() == null) ? "" : Constants.FORMATTER_GLOBAL_INSTANT.format(t.getCreatedAt()));
				dto.setSensorValues((t.getSensorValues() == null) ? "{}" : Arrays.toString(t.getSensorValues()));
				return dto;
			}
		});
	}

	/**
	 * Encargado de parsear los datos de String a Integer <br>
	 * 
	 * @author Jonathan Mosquera.</a></br>
	 * @param numbers
	 * @return
	 */
	public static Integer[] stringArrayToIntegerArray(String[] numbers) {
		Integer[] array = new Integer[numbers.length];
		for (int i = 0; i < array.length; i++) {
			if (numbers[i] != null) {
				array[i] = Integer.parseInt(numbers[i]);
			} else {
				array[i] = null;
			}
		}

		return array;
	}

}
