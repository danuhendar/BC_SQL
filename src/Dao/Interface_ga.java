package Dao;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Archie
 */
public interface Interface_ga {
    
    public String call_get_data(String procedure, boolean option_message);
    public boolean call_upd_fetch(String procedure,boolean option_message);
    public int cek_data(String procedure);
    public boolean cek(String procedure);
    public String call_get_procedure(String procedure,int count_column,boolean option_message);
    public boolean cek_koneksi_db();
    
}