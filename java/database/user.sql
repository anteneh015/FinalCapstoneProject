SELECT users.user_id, username, balance FROM users
JOIN accounts ON users.user_id = accounts.user_id 
WHERE username != 'liping';

SELECT balance FROM accounts WHERE account_id = 2001;

INSERT INTO transfers (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) 
VALUES (DEFAULT, ?, ?, ?, ?, ?);
               
                
SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount, users.username AS username FROM transfers
JOIN accounts ON transfers.account_from = accounts.account_id 
JOIN users ON accounts.user_id = users.user_id 
WHERE transfer_status_id = ? AND account_to = ?

SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount, users.username AS username 
                FROM transfers
                JOIN accounts ON transfers.account_to = accounts.account_id 
                JOIN users ON accounts.user_id = users.user_id 
                WHERE transfer_status_id = 1 AND account_to = ?

SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount, users.username
FROM transfers
JOIN accounts ON transfers.account_from = accounts.account_id
JOIN users ON accounts.user_id = users.user_id
WHERE account_from = 2002 OR account_to = 2002;

SELECT account_id FROM accounts
JOIN users ON accounts.user_id = users.user_id
WHERE username = ?