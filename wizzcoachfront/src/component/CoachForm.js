import React from "react";
import Select from "react-select";
import { useForm, Controller } from "react-hook-form";
import Input from "@material-ui/core/Input";

const CoachForm = () => {
  const { control, handleSubmit } = useForm();

  const onSubmit = (data: IFormInput) => {
    console.log(data)
  };
  const numbers = [' Salut ', 2, 3, 4, 5];
  const listItems = numbers.map((number) =>
    <select>{number}</select>
   
  ); console.log(listItems);
  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <Controller
        name="firstName"
        control={control}
        defaultValue=""
        render={({ onChange, value }) => <input onChange={onChange} value={value} />}
      />
      <Controller
        name="iceCreamType"
        control={control}
        options={
          listItems
        }
        as={Select}
      />
      <input type="submit" />
    </form>
  );
};
export default CoachForm