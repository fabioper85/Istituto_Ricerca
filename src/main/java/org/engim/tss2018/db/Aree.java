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
@Table(name = "aree")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Aree.findAll", query = "SELECT a FROM Aree a")
  , @NamedQuery(name = "Aree.findById", query = "SELECT a FROM Aree a WHERE a.id = :id")
  , @NamedQuery(name = "Aree.findByNome", query = "SELECT a FROM Aree a WHERE a.nome = :nome")
})
public class Aree implements Serializable, ChiavePrimaria
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArea")
  private Collection<Ricercatori> ricercatoriCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArea")
  private Collection<Team> teamCollection;
  @JoinColumn(name = "id_ricercatore", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Ricercatori idRicercatore;

  public Aree()
  {
  }

  public Aree(Integer id)
  {
    this.id = id;
  }

  public Aree(Integer id, String nome)
  {
    this.id = id;
    this.nome = nome;
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

  @XmlTransient
  public Collection<Ricercatori> getRicercatoriCollection()
  {
    return ricercatoriCollection;
  }

  public void setRicercatoriCollection(Collection<Ricercatori> ricercatoriCollection)
  {
    this.ricercatoriCollection = ricercatoriCollection;
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

  public Ricercatori getIdRicercatore()
  {
    return idRicercatore;
  }

  public void setIdRicercatore(Ricercatori idRicercatore)
  {
    this.idRicercatore = idRicercatore;
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
    if (!(object instanceof Aree))
    {
      return false;
    }
    Aree other = (Aree) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "org.engim.tss2018.db.Aree[ id=" + id + " ]";
  }
  
}
