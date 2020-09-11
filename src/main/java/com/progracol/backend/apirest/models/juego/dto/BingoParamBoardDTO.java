package com.progracol.backend.apirest.models.juego.dto;

public class BingoParamBoardDTO {

	private Long id;
	private String boardNumbers;
	private String status;
	private String createdAt;
	private String createdBy;
	private String lastUpdatedAt;
	private String lastUpdatedBy;
	private String deletedAt;
	private String deletedBy;
	private String sensorValues;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBoardNumbers() {
		return boardNumbers;
	}

	public void setBoardNumbers(String boardNumbers) {
		this.boardNumbers = boardNumbers;
	}

	public String getSensorValues() {
		return sensorValues;
	}

	public void setSensorValues(String sensorValues) {
		this.sensorValues = sensorValues;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(String lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

}
