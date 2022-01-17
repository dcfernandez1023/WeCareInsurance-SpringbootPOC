export const getSessionVar = (key) => {
  return window.sessionStorage.getItem(key);
}

export const setSessionVar = (key, value) => {
  window.sessionStorage.setItem(key, value);
}

export const destroySession = () => {
  window.sessionStorage.clear();
}
