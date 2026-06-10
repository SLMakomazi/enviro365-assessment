import { exportWithdrawalsCsv } from '../../services/apiService';
import './WithdrawalTable.css';

function WithdrawalTable({ withdrawals }) {
  const handleDownloadCsv = async () => {
    try {
      const csvData = await exportWithdrawalsCsv();
      const blob = new Blob([csvData], { type: 'text/csv' });
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = 'withdrawals.csv';
      document.body.appendChild(a);
      a.click();
      window.URL.revokeObjectURL(url);
      document.body.removeChild(a);
    } catch (error) {
      console.error('Failed to download CSV:', error);
    }
  };

  return (
    <div className="withdrawal-table-card">
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '16px' }}>
        <h2>Recent Withdrawals</h2>
        <button onClick={handleDownloadCsv} style={{ padding: '8px 16px', cursor: 'pointer' }}>
          Download CSV
        </button>
      </div>
      <table className="withdrawal-table">
        <thead>
          <tr>
            <th>Date</th>
            <th>Amount</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {withdrawals.map((item) => (
            <tr key={item.id}>
              <td>{item.date}</td>
              <td>{item.amount}</td>
              <td>{item.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default WithdrawalTable;
