package fr.treeptik.data.generator.service;

import fr.treeptik.base.model.PersistentStock;

public interface StockMessageService {

	PersistentStock generateRandomCompany();

	void sendMessage();

}
