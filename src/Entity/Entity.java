package Entity;

import org.eclipse.paho.client.mqttv3.MqttClient;

import Dao.Interface_ga;

public class Entity {
	
	static String ip_broker_primary;
	static String port_broker_primary;
    static String username_broker_primary;
    static String password_broker_primary;
    static String cleansession_primary;
    static String keepalive_primary;
    static String reconnect_primary;
    static String will_retained_primary;
    static String max_inflight_primary;
    static String ip_broker_secondary;
    static String port_broker_secondary;
    static String username_broker_secondary;
    static String password_broker_secondary;
    static String cleansession_secondary;
    static String keepalive_secondary;
    static String reconnect_secondary;
    static String will_retained_secondary;
    static String max_inflight_secondary;
    
    
    static String is_mongo_db;
    static String ip_mongodb;
    static String port_mongodb;
    static String ip_database;
    static String user_database;
    static String pass_database;
    static String port_database;
    static String nama_database;
    static String id_reporter;
    static String cabang;
    static String topic;
    static String tampilkan_query_console;
    static String batas_menit;
    static String tulis_log;
    static MqttClient client;
    static Interface_ga inter_login;
	 
    
	public static String getTulis_log() {
		return tulis_log;
	}
	public static void setTulis_log(String tulis_log) {
		Entity.tulis_log = tulis_log;
	}
	public static String getIp_broker_primary() {
		return ip_broker_primary;
	}
	public static void setIp_broker_primary(String ip_broker_primary) {
		Entity.ip_broker_primary = ip_broker_primary;
	}
	public static String getPort_broker_primary() {
		return port_broker_primary;
	}
	public static void setPort_broker_primary(String port_broker_primary) {
		Entity.port_broker_primary = port_broker_primary;
	}
	public static String getUsername_broker_primary() {
		return username_broker_primary;
	}
	public static void setUsername_broker_primary(String username_broker_primary) {
		Entity.username_broker_primary = username_broker_primary;
	}
	public static String getPassword_broker_primary() {
		return password_broker_primary;
	}
	public static void setPassword_broker_primary(String password_broker_primary) {
		Entity.password_broker_primary = password_broker_primary;
	}
	public static String getCleansession_primary() {
		return cleansession_primary;
	}
	public static void setCleansession_primary(String cleansession_primary) {
		Entity.cleansession_primary = cleansession_primary;
	}
	public static String getKeepalive_primary() {
		return keepalive_primary;
	}
	public static void setKeepalive_primary(String keepalive_primary) {
		Entity.keepalive_primary = keepalive_primary;
	}
	public static String getReconnect_primary() {
		return reconnect_primary;
	}
	public static void setReconnect_primary(String reconnect_primary) {
		Entity.reconnect_primary = reconnect_primary;
	}
	public static String getWill_retained_primary() {
		return will_retained_primary;
	}
	public static void setWill_retained_primary(String will_retained_primary) {
		Entity.will_retained_primary = will_retained_primary;
	}
	public static String getMax_inflight_primary() {
		return max_inflight_primary;
	}
	public static void setMax_inflight_primary(String max_inflight_primary) {
		Entity.max_inflight_primary = max_inflight_primary;
	}
	public static String getIp_broker_secondary() {
		return ip_broker_secondary;
	}
	public static void setIp_broker_secondary(String ip_broker_secondary) {
		Entity.ip_broker_secondary = ip_broker_secondary;
	}
	public static String getPort_broker_secondary() {
		return port_broker_secondary;
	}
	public static void setPort_broker_secondary(String port_broker_secondary) {
		Entity.port_broker_secondary = port_broker_secondary;
	}
	public static String getUsername_broker_secondary() {
		return username_broker_secondary;
	}
	public static void setUsername_broker_secondary(String username_broker_secondary) {
		Entity.username_broker_secondary = username_broker_secondary;
	}
	public static String getPassword_broker_secondary() {
		return password_broker_secondary;
	}
	public static void setPassword_broker_secondary(String password_broker_secondary) {
		Entity.password_broker_secondary = password_broker_secondary;
	}
	public static String getCleansession_secondary() {
		return cleansession_secondary;
	}
	public static void setCleansession_secondary(String cleansession_secondary) {
		Entity.cleansession_secondary = cleansession_secondary;
	}
	public static String getKeepalive_secondary() {
		return keepalive_secondary;
	}
	public static void setKeepalive_secondary(String keepalive_secondary) {
		Entity.keepalive_secondary = keepalive_secondary;
	}
	public static String getReconnect_secondary() {
		return reconnect_secondary;
	}
	public static void setReconnect_secondary(String reconnect_secondary) {
		Entity.reconnect_secondary = reconnect_secondary;
	}
	public static String getWill_retained_secondary() {
		return will_retained_secondary;
	}
	public static void setWill_retained_secondary(String will_retained_secondary) {
		Entity.will_retained_secondary = will_retained_secondary;
	}
	public static String getMax_inflight_secondary() {
		return max_inflight_secondary;
	}
	public static void setMax_inflight_secondary(String max_inflight_secondary) {
		Entity.max_inflight_secondary = max_inflight_secondary;
	}
	public static String getIs_mongo_db() {
		return is_mongo_db;
	}
	public static void setIs_mongo_db(String is_mongo_db) {
		Entity.is_mongo_db = is_mongo_db;
	}
	public static String getIp_mongodb() {
		return ip_mongodb;
	}
	public static void setIp_mongodb(String ip_mongodb) {
		Entity.ip_mongodb = ip_mongodb;
	}
	public static String getPort_mongodb() {
		return port_mongodb;
	}
	public static void setPort_mongodb(String port_mongodb) {
		Entity.port_mongodb = port_mongodb;
	}
 
	public static String getIp_database() {
		return ip_database;
	}
	public static void setIp_database(String ip_database) {
		Entity.ip_database = ip_database;
	}
	public static String getUser_database() {
		return user_database;
	}
	public static void setUser_database(String user_database) {
		Entity.user_database = user_database;
	}
	public static String getPass_database() {
		return pass_database;
	}
	public static void setPass_database(String pass_database) {
		Entity.pass_database = pass_database;
	}
	public static String getPort_database() {
		return port_database;
	}
	public static void setPort_database(String port_database) {
		Entity.port_database = port_database;
	}
	public static String getNama_database() {
		return nama_database;
	}
	public static void setNama_database(String nama_database) {
		Entity.nama_database = nama_database;
	}
	public static String getId_reporter() {
		return id_reporter;
	}
	public static void setId_reporter(String id_reporter) {
		Entity.id_reporter = id_reporter;
	}
	public static String getCabang() {
		return cabang;
	}
	public static void setCabang(String cabang) {
		Entity.cabang = cabang;
	}
	public static String getTopic() {
		return topic;
	}
	public static void setTopic(String topic) {
		Entity.topic = topic;
	}
	public static String getTampilkan_query_console() {
		return tampilkan_query_console;
	}
	public static void setTampilkan_query_console(String tampilkan_query_console) {
		Entity.tampilkan_query_console = tampilkan_query_console;
	}
	public static String getBatas_menit() {
		return batas_menit;
	}
	public static void setBatas_menit(String batas_menit) {
		Entity.batas_menit = batas_menit;
	}
	public static MqttClient getClient() {
		return client;
	}
	public static void setClient(MqttClient client) {
		Entity.client = client;
	}
	public static Interface_ga getInter_login() {
		return inter_login;
	}
	public static void setInter_login(Interface_ga inter_login) {
		Entity.inter_login = inter_login;
	}
    
    
    
   
}
