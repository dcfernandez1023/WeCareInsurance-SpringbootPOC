const getSessionVar = (key) => {
  return window.sessionStorage.getItem(key);
}

const setSessionVar = (key, value) => {
  window.sessionStorage.setItem(key, value);
}

const destroySession = () => {
  window.sessionStorage.clear();
}

export { getSessionVar, setSessionVar, destroySession };
