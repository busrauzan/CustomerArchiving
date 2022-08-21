package com.busrauzan.customerarchiving.DataAccess;

import com.busrauzan.customerarchiving.Entities.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

}