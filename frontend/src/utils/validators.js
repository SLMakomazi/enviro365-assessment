export const isRequired = (value) => value != null && value.toString().trim().length > 0;

export const isValidAmount = (value) => {
  const amount = Number(value);
  return Number.isFinite(amount) && amount > 0;
};
