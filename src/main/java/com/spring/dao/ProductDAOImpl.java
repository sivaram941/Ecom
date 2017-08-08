package com.spring.dao;

    import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session; 
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CategoryDAO;
	import com.spring.dao.ProductDAO;
	import com.spring.model.Category;
	import com.spring.model.Product;
import com.spring.model.Users;

	@SuppressWarnings("deprecation")
	@Repository
	public class ProductDAOImpl implements ProductDAO
	{
		@Autowired
		SessionFactory sessionFactory;  
		
		public ProductDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public boolean saveProduct(Product product) {

			sessionFactory.getCurrentSession().saveOrUpdate(product);

			return true;
		}

		@Transactional
		public List<Product> list() {
			@SuppressWarnings("unchecked")
			List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product .class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

			return listProduct;
		}

		@Transactional
		public Product getProductById(int product_id) {
			String hql = "from" + " Category" + " where id=" + product_id;
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			@SuppressWarnings("unchecked")
			List<Product> listProduct = (List<Product>) query.list();

			if (listProduct != null && !listProduct.isEmpty()) {
				return listProduct.get(0);
			}

			return null;
		}

		@Transactional
		public Product removeProductById(int product_id) {
			Product ProductToDelete = new Product();
			ProductToDelete.setId(product_id);
			sessionFactory.getCurrentSession().delete(ProductToDelete);
			return ProductToDelete;
		}

		public boolean saveorupdate(Product product) {
			// TODO Auto-generated method stub
			return false;
		}

	}