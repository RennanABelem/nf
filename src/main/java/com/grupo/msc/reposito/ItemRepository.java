package com.grupo.msc.reposito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo.msc.model.ItemDaNota;

@Repository
public interface ItemRepository extends JpaRepository<ItemDaNota, Long>{

}
