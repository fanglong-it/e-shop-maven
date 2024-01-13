package fpt.edu.eshop.dao;

public class AccountDAO extends MyDAO {

    public entity.Account getByEmail(String email) {
        String query = "select * from Account where email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new entity.Account(rs.getInt("id"),
                        rs.getString("user"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("phone"),
                        rs.getString("describe"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public entity.Account updateAccountPassword(entity.Account account) {
        String query = "update Account set password = ? where id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, account.getPassword());
            ps.setInt(2, account.getId());
            if (ps.executeUpdate() > 0) {
                return getByEmail(account.getEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
