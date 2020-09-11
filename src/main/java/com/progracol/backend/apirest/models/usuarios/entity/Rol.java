package com.progracol.backend.apirest.models.usuarios.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bingo_rol")
public class Rol implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "bingo_rol_rol_id_seq", sequenceName = "bingo_rol_rol_id_seq", allocationSize = 1)
  @GeneratedValue(generator = "bingo_rol_rol_id_seq")
  @Column(name = "rol_id", nullable = false)
  private Long id;

  @NotNull
  @Size(max = 50)
  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Size(max = 1)
  @NotNull
  @Column(name = "status", length = 1, nullable = false)
  private String status;

  @Column(name = "readonly")
  private Integer readonly;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getReadonly() {
    return readonly;
  }

  public void setReadonly(Integer readonly) {
    this.readonly = readonly;
  }
}
