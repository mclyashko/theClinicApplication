import {AUTH_FAILURE_ROUTE, CORRECT_TIME_ROUTE, LOGIN_ROUTE, REGISTER_ROUTE, USER_EXISTS_ROUTE, WRONG_TIME_ROUTE} from "./consts";
import LoginPage from "../page/LoginPage/LoginPage";
import RegisterPage from "../page/RegisterPage/RegisterPage";
import AuthenticationFailurePage from "../page/AuthenticationFailurePage/AuthenticationFailurePage";
import CorrectTimePage from "../page/CorrectTimePage/CorrectTimePage";
import UserExistsPage from "../page/UserExistsPage/UserExistsPage";
import WrongTimePage from "../page/WrongTimePage/WrongTimePage";
import LoginRegisterPage from "../page/LoginRegisterPage/LoginRegisterPage";

export const publicRoutes = [
    // {
    //     path: LOGIN_ROUTE,
    //     Element: LoginPage
    // },
    // {
    //     path: REGISTER_ROUTE,
    //     Element: RegisterPage
    // },
    // {
    //     path: AUTH_FAILURE_ROUTE,
    //     Element: AuthenticationFailurePage
    // },
    // {
    //     path: CORRECT_TIME_ROUTE,
    //     Element: CorrectTimePage
    // },
    // {
    //     path: USER_EXISTS_ROUTE,
    //     Element: UserExistsPage
    // },
    // {
    //     path: WRONG_TIME_ROUTE,
    //     Element: WrongTimePage
    // }
    {
        path: LOGIN_ROUTE,
        Element: LoginRegisterPage
    }
]
