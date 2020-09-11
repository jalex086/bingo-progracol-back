package com.progracol.backend.apirest.models.juego.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.progracol.backend.apirest.models.juego.entity.BingoParamBoard;

@Repository
public interface IBingoParamBoardDao extends JpaRepository<BingoParamBoard, Long> {

	@Query("SELECT bpb FROM BingoParamBoard bpb")
	Page<BingoParamBoard> findAllBingoParamBoards(Pageable pageable);

	@Query("SELECT bpb FROM BingoParamBoard bpb")
	List<BingoParamBoard> findAllBingoParamBoards();
}
