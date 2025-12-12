def read_file(filename)
    begin
        puts "opening file..."
        file = File.open(filename, "r") #raises error file not found
        begin
            puts "reading file..."
            data = file.read
            return data
        ensure
            puts 'closing file...'
            file.close if file
        end 
    rescue Errno::ENOENT => e
        puts "file not found: #{e.message}"
        raise
    rescue IOError => e
        puts "General exception: #{e.message}"
        raise
    end
end

def main
    begin
        read_file("does_not_exist.txt")
    rescue => e
        puts "propagated to main: #{e.message}"
    ensure
        puts "execution completed."
    end
end

main