package dev.mvc.storage;

import java.util.ArrayList;


public interface StorageMapperInter{
  // <insert id="create" parameterType="StorageVO">
  public int create(StorageVO storageVO);
  
  
  // <select id="list" resultType="StorageVO">
  public ArrayList<StorageVO> list(); 
  
  // <update id="update" parameterType="StorageVO">
  public int update(StorageVO storageVO);
  
  // <delete id="delete" parameterType="int">
  public int delete(int storageno);
}
