import React from 'react';
import Wrapper from "../../Wrapper/Wrapper";
import RegisterName from "../RegisterName/RegisterName";
import RegisterSurname from "../RegisterSurname/RegisterSurname";
import RegisterPatronymic from "../RegisterPatronymic/RegisterPatronymic";
import RegisterGender from "../RegisterGender/RegisterGender";
import RegisterDateOfBirth from "../RegisterDateOfBirth/RegisterDateOfBirth";
import RegisterPhoneNumber from "../RegisterPhoneNumber/RegisterPhoneNumber";
import RegisterEmail from "../RegisterEmail/RegisterEmail";
import RegisterPassword from "../RegisterPassword/RegisterPassword";
import RegisterSubmit from "../RegisterSubmit/RegisterSubmit";
import RegistrationToLogin from "../RegistrationToLogin/RegistrationToLogin";

const Register = () => {
    return (
        <div style = {{ display: 'flex', alignItems: 'center', justifyContent: 'center', minHeight: '100vh'}}>
            <Wrapper>
                <div className="login-form mg" style = {{ paddingLeft: '15vw', paddingRight: '15vw'}}>
                    <form action="/registration" method="POST">
                        <h2 className="text-center pd1">Регистрация</h2>
                        <RegisterName/>
                        <RegisterSurname/>
                        <RegisterPatronymic/>
                        <RegisterGender/>
                        <RegisterDateOfBirth/>
                        <RegisterPhoneNumber/>
                        <RegisterEmail/>
                        <RegisterPassword/>
                    </form>
                    <RegisterSubmit/>
                    <RegistrationToLogin/>
                </div>
            </Wrapper>
        </div>
    )
}

export default Register
