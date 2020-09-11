package com.progracol.backend.apirest.models.usuarios.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "bingo_users")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "bingo_users_user_id_seq", sequenceName = "bingo_users_user_id_seq", allocationSize = 1)
  @GeneratedValue(generator = "bingo_users_user_id_seq")
  @Column(name = "user_id", nullable = false)
  private Long id;

  @NotNull
  @Size(max = 512)
  @Column(name = "username", length = 512, nullable = false)
  private String username;

  @NotNull
  @Size(max = 256)
  @Column(name = "names", length = 256, nullable = false)
  private String name;

  @Column(name = "img_url", length = 2048, columnDefinition = "TEXT")
  private String imgUrl;

  @NotNull
  @Size(max = 256)
  @Column(name = "last_names", length = 256, nullable = false)
  private String lastNames;

  @NotNull
  @Size(min = 6, max = 512)
  @Column(name = "password", length = 512, nullable = false)
  private String password;

  @NotNull
  @Size(max = 1)
  @Column(name = "status", length = 1, nullable = false)
  private String status;

  @Column(name = "expired")
  private Boolean expired;

  @Column(name = "locked")
  private Boolean locked;

  @Column(name = "credrencials_expired")
  private Boolean credrencialsExpired;

  @Size(max = 255)
  @Column(name = "phone", length = 255)
  private String phone;

  @Size(max = 128)
  @Column(name = "position", length = 128)
  private String position;

  @Size(max = 100)
  @Column(name = "cedula", length = 100)
  private String cedula;

  @Column(name = "preregister")
  private Boolean preregister;

  @Column(name = "nacimiento")
  private Instant nacimiento;

  @Column(name = "maxrecharge")
  private Long maxrecharge;

  @NotNull
  @Column(name = "rol_id", nullable = false)
  private Long rolId;

  @JoinColumn(name = "rol_id", referencedColumnName = "rol_id", updatable = false, insertable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JsonIgnore
  private Rol rol;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getLastNames() {
    return lastNames;
  }

  public void setLastNames(String lastNames) {
    this.lastNames = lastNames;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Boolean getExpired() {
    return expired;
  }

  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  public Boolean getLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public Boolean getCredrencialsExpired() {
    return credrencialsExpired;
  }

  public void setCredrencialsExpired(Boolean credrencialsExpired) {
    this.credrencialsExpired = credrencialsExpired;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getCedula() {
    return cedula;
  }

  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

  public Boolean getPreregister() {
    return preregister;
  }

  public void setPreregister(Boolean preregister) {
    this.preregister = preregister;
  }

  public Instant getNacimiento() {
    return nacimiento;
  }

  public void setNacimiento(Instant nacimiento) {
    this.nacimiento = nacimiento;
  }

  public Long getMaxrecharge() {
    return maxrecharge;
  }

  public void setMaxrecharge(Long maxrecharge) {
    this.maxrecharge = maxrecharge;
  }

  public Long getRolId() {
    return rolId;
  }

  public void setRolId(Long rolId) {
    this.rolId = rolId;
  }

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }
}
