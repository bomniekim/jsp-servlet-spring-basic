package bomnie.jdbc_study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bomnie.jdbc_study.dto.Role;

public class RoleDao {
	
	// 반복 사용을 위해 전역변수로 설정
	
	// DB timezone 설정 
	private static String dburl = "jdbc:mysql://localhost:3306/bomin_DB?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true";
	private static String dbUser = "bomnie";
	private static String dbpasswd = "bomin331";

	
	
	// 1. roleId를 이용해서 데이터 조회값을 담은 Role 객체를 리턴하는 메소드
	public Role getRole(Integer roleId) {
		// Role 객체 생성
		Role role = null;
		
		// JDBC를 이용하기 위한 단계별 프로그램 수행
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		// 순차적으로 DB 연결
		try {
			// 1) mysql이 제공하는 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2) driver manager를 이용해 connection 인스턴스 얻어오기
			connection = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT description, role_id FROM role WHERE role_id = ?"; 
				// 쿼리문 작성: 변수가 들어갈 자리는 '?'로 표시하는 것이 PreparedStatement의 특징 (효율성)
			
			// 3)connection을 통해 statement 얻어오기
			ps = connection.prepareStatement(sql);
//			ps.setInt(?의 순서, ?대신 넣을 값);
			ps.setInt(1, roleId);
			
			// 4) ResultSet으로 결과받기
			rs = ps.executeQuery();
			if(rs.next()) {
				// next(): 결과 값이 있다면 첫번째 레코드로 이동한 후 true 리턴 
				
				// 쿼리문의 컬럼 순서에 맞추어 결과값 꺼내오기 (실제 테이블의 순서와 무관)
				String description = rs.getString(1);  // 컬럼의 index로 불러오기
				int id = rs.getInt("role_id");  // 컬럼명으로 불러오기
				
				role = new Role(id, description);
				
				
			}
		} catch (Exception e) {
			
		} finally { // 어떤 일이 있어도 반드시 수행되는 블럭
			// 객체 역순으로 닫아주기
			if(rs !=null) {	// NullPointerException 방지를 위한 조건문 처리  
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps !=null) {				
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection !=null) {				
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return role;
	}
	
	
	
	
	// 2. 새로운 값을 담은 Role 객체를 사용해서 DB에 값을 추가하는 메소드 
	public int addRole(Role role) {
		// insert, update, delete 쿼리 수행 시 실행된 결과의 횟수를 담는 변수 
		int insertCount = 0;
		 
		// DB 관련 객체
		Connection conn = null;
		PreparedStatement ps = null;
		// insert 쿼리를 사용하므로 결과를 담는 ResultSet 필요하지 않음 
		
		try {
			// 드라이버 로드
			// mysql 8.0.16 부터 중간에 'cj' 패키지 추가
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// DB 연결 
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			// 쿼리 
			String sql = "insert into role(role_id, description) values(?, ?)";
			ps = conn.prepareStatement(sql);
			
			// 쿼리의 변수 ?에 들어갈 값을 바인딩 
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDesc());
			
			// executeUpdate()는 insert, update, delete 쿼리 수행 시 사
			// 업데이트된 레코드의 수(int 값)를 반환
			insertCount = ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				}
				catch (SQLException e){
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e){
					e.printStackTrace();
				}
			}

		}
		
		return insertCount;
	}
	
	
	
	
	
	// 3. Role 객체에 대응하는 데이터를 수정하는 메소드
	public int updateRole(Role role) {
		
		int updateCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		// ResultSet 필요없음
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "update role set description = ? where role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, role.getDesc());
			ps.setInt(2, role.getRoleId());
			updateCount = ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
		return updateCount;
	}
	
	
	
		
	// 4. roleId 에 대응하는 데이터를 삭제하는 메소드
	public int deleteRole(Integer roleId) {
		int deleteCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "DELETE FROM role WHERE role_id = ?";

			ps = conn.prepareStatement(sql);
			
			ps.setInt(1,  roleId);

			deleteCount = ps.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} 
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} 
		} // finally

		return deleteCount;
	}
		
	
	
	
	// 5. 모든 레코드 조회하는 메소드
	public List<Role> getRoles() { // 모든 정보를 조회하여 반환할 수 있도록 List<Role>을 리턴 
		List<Role> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT description, role_id FROM role order by role_id desc";
		
		// * try-with resource
		// try () 에 사용한 리소스를 얻어오는 코드를 작성하면, 실행 후 리소스들을 자동으로 close
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) { // 여러 개의 정보 조회
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					
					// Role객체를 생성한 후 데이터 담기 
					Role role = new Role(id, description);
					list.add(role); // 반복될 때마다 list에 Role 인스턴스를 생성하여 추가
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	
}