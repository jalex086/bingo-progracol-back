package com.progracol.backend.apirest.models.juego.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.progracol.backend.apirest.models.juego.entity.BingoParamFigure;

@Repository
public interface IBingoParamFigureDao extends CrudRepository<BingoParamFigure, Long> {

	@Query("SELECT bpb FROM BingoParamFigure bpb WHERE bpb.figureName = :figureName")
	BingoParamFigure finByFigureName(@Param("figureName") String figureName);
}
