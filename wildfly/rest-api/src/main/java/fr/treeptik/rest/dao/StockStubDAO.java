package fr.treeptik.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import fr.treeptik.base.model.PersistentStock;

@Profile("tomcat")
@Repository
public class StockStubDAO implements StockDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PersistentStock save(PersistentStock persistentStock) {
		throw new RuntimeException("NOT IMPL");
	}

	@Override
	public List<PersistentStock> list() {
		List<PersistentStock> persistentStockList = new ArrayList<>();
		for(int i=0; i<15; i++) {
			persistentStockList.add(generateRandomCompany());
		}
		return persistentStockList;
	}

	private String[] companiesNames = { "IBM", "Oracle", "Docker", "Treeptik", "Xebia",
			"MacDo", "CocaCola", "Apple", "Intel", "VmWare",
			"Hooli", "PipePiper", "AnaoTech", "Rothschild", "SG",};

	private PersistentStock generateRandomCompany() {
		PersistentStock stock = new PersistentStock();
		stock.setChanges(new Random().nextDouble());
		stock.setName(companiesNames[new Random().nextInt(15)]);
		stock.setPrice(new Random().nextDouble());
		stock.setValue(new Random().nextDouble());
		stock.setShare(new Random().nextInt());
		return stock;
	}
}
