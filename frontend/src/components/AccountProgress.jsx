export default function AccountProgress({
  accountName,
  amount,
  className,
  value,
}) {
  return (
    <>
      <h4>
        <b>{accountName}:</b> £{amount}
      </h4>
      <progress className={className} value={value} max="100" />
    </>
  );
}
