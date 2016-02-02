package com.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bean.Batch;

public class BatchDao
{
	SessionFactory sf;  

	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public List<Batch> getAllBatch()
	{
		Session s=sf.openSession();
		Query query= s.createQuery("from Batch");
		List<Batch> b_lst=query.list();
		 s.close();
		return b_lst;
       
	}

	public void addBatch(Batch b){
		
		Session s=sf.openSession();
		Transaction tx= s.beginTransaction();
		s.save(b);
		tx.commit();
		s.close();
	}
	public void deleteBatch(Batch b){
		Session s=sf.openSession();
		Transaction tx= s.beginTransaction();
		s.load(Batch.class, b.getBatch_id());
		s.delete(b);
		tx.commit();
		s.close();
	}
}
