def read_file(filename):
    try:
        print("opening file...")
        f = open(filename, 'r')
        try:
            print("reading file...")
            data = f.read()
            return data
        finally:
            print("closing file...")
            f.close()
    except IOError as e:
        print("file not found:", e)
        raise
    except Exception as e:
        print("an error occurred:", e)
        raise

def main():
    try:
        content = read_file("does_not_exist.txt")
        print(content)
    except Exception as e:
        print('propagated to main', e)
    finally:
        print("done.")
    
    if __name__ == "__main__":
        main()