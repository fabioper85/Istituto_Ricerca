/*
 * Copyright 2018 svilupposw.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.engim.tss2018.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author svilupposw
 */
@Entity
@Table(name = "ricercatori")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Ricercatori.findAll", query = "SELECT r FROM Ricercatori r")
  , @NamedQuery(name = "Ricercatori.findById", query = "SELECT r FROM Ricercatori r WHERE r.id = :id")
  , @NamedQuery(name = "Ricercatori.findByNome", query = "SELECT r FROM Ricercatori r WHERE r.nome = :nome")
  , @NamedQuery(name = "Ricercatori.findByCognome", query = "SELECT r FROM Ricercatori r WHERE r.cognome = :cognome")
  , @NamedQuery(name = "Ricercatori.findByStipendioBase", query = "SELECT r FROM Ricercatori r WHERE r.stipendioBase = :stipendioBase")
  , @NamedQuery(name = "Ricercatori.findByBonus", query = "SELECT r FROM Ricercatori r WHERE r.bonus = :bonus")
  , @NamedQuery(name = "Ricercatori.findByRuolo", query = "SELECT r FROM Ricercatori r WHERE r.ruolo = :ruolo")
})
public class Ricercatori implements Serializable, ChiavePrimaria
{

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 250)
  @Column(name = "nome")
  private String nome;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 250)
  @Column(name = "cognome")
  private String cognome;
  @Basic(optional = false)
  @NotNull
  @Column(name = "stipendio_base")
  private double stipendioBase;
  @Basic(optional = false)
  @NotNull
  @Column(name = "bonus")
  private double bonus;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ruolo")
  private Character ruolo;
  @JoinColumn(name = "id_progetto", referencedColumnName = "codice")
  @ManyToOne(optional = false)
  private Progetti idProgetto;
  @JoinColumn(name = "id_team", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Team idTeam;
  @JoinColumn(name = "id_area", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Aree idArea;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeamleader")
  private Collection<Team> teamCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRicercatore")
  private Collection<Aree> areeCollection;

  public Ricercatori()
  {
  }

  public Ricercatori(Integer id)
  {
    this.id = id;
  }

  public Ricercatori(Integer id, String nome, String cognome, double stipendioBase, double bonus, Character ruolo)
  {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.stipendioBase = stipendioBase;
    this.bonus = bonus;
    this.ruolo = ruolo;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getNome()
  {
    return nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public String getCognome()
  {
    return cognome;
  }

  public void setCognome(String cognome)
  {
    this.cognome = cognome;
  }

  public double getStipendioBase()
  {
    return stipendioBase;
  }

  public void setStipendioBase(double stipendioBase)
  {
    this.stipendioBase = stipendioBase;
  }

  public double getBonus()
  {
    return bonus;
  }

  public void setBonus(double bonus)
  {
    this.bonus = bonus;
  }

  public Character getRuolo()
  {
    return ruolo;
  }

  public void setRuolo(Character ruolo)
  {
    this.ruolo = ruolo;
  }

  public Progetti getIdProgetto()
  {
    return idProgetto;
  }

  public void setIdProgetto(Progetti idProgetto)
  {
    this.idProgetto = idProgetto;
  }

  public Team getIdTeam()
  {
    return idTeam;
  }

  public void setIdTeam(Team idTeam)
  {
    this.idTeam = idTeam;
  }

  public Aree getIdArea()
  {
    return idArea;
  }

  public void setIdArea(Aree idArea)
  {
    this.idArea = idArea;
  }

  @XmlTransient
  public Collection<Team> getTeamCollection()
  {
    return teamCollection;
  }

  public void setTeamCollection(Collection<Team> teamCollection)
  {
    this.teamCollection = teamCollection;
  }

  @XmlTransient
  public Collection<Aree> getAreeCollection()
  {
    return areeCollection;
  }

  public void setAreeCollection(Collection<Aree> areeCollection)
  {
    this.areeCollection = areeCollection;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Ricercatori))
    {
      return false;
    }
    Ricercatori other = (Ricercatori) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "org.engim.tss2018.db.Ricercatori[ id=" + id + " ]";
  }
  
}
