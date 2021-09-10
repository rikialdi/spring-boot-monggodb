package com.binar.binar.repository;


import com.binar.binar.entity.Barang;
import com.binar.binar.model.ModelBarang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
// wajib anotasi repo
@Repository
//public interface BarangRepo extends PagingAndSortingRepository<Barang, Long> {
public interface BarangRepo extends JpaRepository<Barang, Long> {
    // JPQL ==============================
    @Query("select c from Barang c WHERE c.id = :id")
    public Barang getbyID(@Param("id") Long id);

    @Query("select c from Barang c")// nama class
    public List<Barang> getList();

    @Query("select c from Barang c WHERE c.nama = :nama")// nama class
    Page<Barang> getbyNama(String nama, Pageable pageable);

    // JPA ===================
    Page<Barang> findByNama(String nama, Pageable pageable);

    Page<Barang> findByNamaLike(String nama, Pageable pageable);

    // step 2 DTO ENTITAS :
    @Query(value="select new com.binar.binar.model.ModelBarang(a.id, a.nama) from Barang a")
    List<ModelBarang> modelDTO();

    // Native ==========================
    @Query(value="select * from barang a where a.nama= :nama", nativeQuery=true)
    Object[] getbyNamaNative(@Param("nama") String nama);

    @Query(value="select count(*) from barang a", nativeQuery=true)
    Long countData();



    @Modifying
    @Query(value="delete from barang a where a.id= :id", nativeQuery = true)
    void deletenativebyid(@Param("id") Long id);

    @Modifying
    @Query(value="update barang set nama= :nama where id = :id", nativeQuery=true)
    void updatenativebyid(@Param("id") Long id, @Param("nama") String nama);

    // step 2
    @Query(value = "SELECT p.id, p.nama FROM barang p ", nativeQuery = true)
    List<Object[]> getDataAllNative();

//    @Query("select c from TempSesiEventZona c WHERE c.event.id = :id and c.team.id =:teamid")
//    public List<TempSesiEventZona> getbyeventandTeam(@Param("id") Long id, @Param("teamid") Long teamid);



}