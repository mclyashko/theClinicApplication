import {combineReducers, legacy_createStore as createStore} from "@reduxjs/toolkit";
import loginPageReducer from "../reducer/LoginPageReducer/LoginPageReducer";
import userInfoReducer from "../reducer/UserInfoReducer/UserInfoReducer";

const saveToLocalStorage = (state) => {
    try {
        localStorage.setItem('state', JSON.stringify(state));
    } catch (e) {
        console.error(e);
    }
};

const loadFromLocalStorage = () => {
    try {
        const stateStr = localStorage.getItem('state');
        return stateStr ? JSON.parse(stateStr) : undefined;
    } catch (e) {
        console.error(e);
        return undefined;
    }
};

const rootReducer = combineReducers({
    login: loginPageReducer,
    userInf: userInfoReducer
})

const persistedStore = loadFromLocalStorage();

const store = createStore(rootReducer, persistedStore);

store.subscribe(() => {
    saveToLocalStorage(store.getState());
});

export default store;
