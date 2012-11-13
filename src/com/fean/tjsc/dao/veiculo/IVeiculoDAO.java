package com.fean.tjsc.dao.veiculo;
// default package

import java.util.List;
import java.util.Set;


/**
 * Interface for VeiculoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVeiculoDAO {
	/**
	 * Perform an initial save of a previously unsaved Veiculo entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVeiculoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Veiculo entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Veiculo entity);

	/**
	 * Delete a persistent Veiculo entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVeiculoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Veiculo entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Veiculo entity);

	/**
	 * Persist a previously saved Veiculo entity and return it or a copy of it
	 * to the sender. A copy of the Veiculo entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVeiculoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Veiculo entity to update
	 * @return Veiculo the persisted Veiculo entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Veiculo update(Veiculo entity);

	public Veiculo findById(Integer id);

	/**
	 * Find all Veiculo entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Veiculo property to query
	 * @param value
	 *            the property value to match
	 * @return List<Veiculo> found by query
	 */
	public List<Veiculo> findByProperty(String propertyName, Object value);

	public List<Veiculo> findByPlaca(Object placa);

	public List<Veiculo> findByRevavan(Object revavan);

	public List<Veiculo> findByChassi(Object chassi);

	public List<Veiculo> findByOdometro(Object odometro);

	public List<Veiculo> findBySituacao(Object situacao);

	/**
	 * Find all Veiculo entities.
	 * 
	 * @return List<Veiculo> all Veiculo entities
	 */
	public List<Veiculo> findAll();
}