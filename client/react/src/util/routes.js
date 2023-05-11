import LoginRegisterPage from "../page/LoginRegisterPage/LoginRegisterPage";
import {DOCTOR_HOME_ROUTE, LOGIN_ROUTE, PATIENT_HOME_ROUTE} from "./consts";
import DoctorHomePage from "../page/DoctorHomePage/DoctorHomePage";
import PatientHomePage from "../page/PatientHomePage/PatientHomePage";

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
    },
    {
        path: DOCTOR_HOME_ROUTE,
        Element: DoctorHomePage
    },
    {
        path: PATIENT_HOME_ROUTE,
        Element: PatientHomePage
    }
]
