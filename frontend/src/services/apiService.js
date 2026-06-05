import axiosClient from '../api/axiosClient';

export const fetchPortfolio = async () => {
  const response = await axiosClient.get('/portfolio');
  return response.data;
};

export const submitWithdrawal = async (payload) => {
  const response = await axiosClient.post('/withdrawals', payload);
  return response.data;
};

export const fetchWithdrawals = async () => {
  const response = await axiosClient.get('/withdrawals');
  return response.data;
};

export const fetchHistory = async () => {
  const response = await axiosClient.get('/history');
  return response.data;
};
